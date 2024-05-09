import { Dialog, Disclosure, Menu, Transition } from '@headlessui/react'
import { ChevronDownIcon, MinusIcon, PlusIcon, Squares2X2Icon, Bars3Icon } from '@heroicons/react/20/solid'

const subCategories = [
    { name: 'Dashboard', href: '#' },
    { name: 'Documentacion', href: '#' },
    { name: 'Agenda', href: '#' },
    { name: 'Clientes', href: '#' },
    { name: 'SubCategories5', href: '#' },
]
const subMenus = [
    {
        id: 'color',
        name: 'Color',
        options: [
            { value: 'white', label: 'White', checked: false },
            { value: 'beige', label: 'Beige', checked: false },
            { value: 'blue', label: 'Blue', checked: true },
            { value: 'brown', label: 'Brown', checked: false },
            { value: 'green', label: 'Green', checked: false },
            { value: 'purple', label: 'Purple', checked: false },
        ],
    },
    {
        id: 'category',
        name: 'Category',
        options: [
            { value: 'new-arrivals', label: 'New Arrivals', checked: false },
            { value: 'sale', label: 'Sale', checked: false },
            { value: 'travel', label: 'Travel', checked: true },
            { value: 'organization', label: 'Organization', checked: false },
            { value: 'accessories', label: 'Accessories', checked: false },
        ],
    },
    {
        id: 'size',
        name: 'Size',
        options: [
            { value: '2l', label: '2L', checked: false },
            { value: '6l', label: '6L', checked: false },
            { value: '12l', label: '12L', checked: false },
            { value: '18l', label: '18L', checked: false },
            { value: '20l', label: '20L', checked: false },
            { value: '40l', label: '40L', checked: true },
        ],
    },
]

export default function LeftMenuDash() {
    return (
        <form className="hidden lg:block">
            <div className='bg-[#100C18] text-base text-white h-full border border-white rounded-2xl px-3 py-3'>
                <ul role="list" className="space-y-4 border-b border-gray-200 pb-6 font-medium">
                    {subCategories.map((category) => (
                        <li key={category.name}>
                            <a href={category.href}>{category.name}</a>
                        </li>
                    ))}
                </ul>

                {subMenus.map((section) => (

                    <Disclosure as="div" key={section.id} className="border-b border-gray-200 py-6">
                        {({ open }) => (
                            <>
                                <h3 className="-my-3 flow-root">
                                    <Disclosure.Button className="flex w-full items-center justify-between bg-white py-3 text-sm text-gray-400 hover:text-gray-500">
                                        <span className="font-medium text-gray-900">{section.name}</span>
                                        <span className="ml-6 flex items-center">
                                            {open ? (
                                                <MinusIcon className="h-5 w-5" aria-hidden="true" />
                                            ) : (
                                                <PlusIcon className="h-5 w-5" aria-hidden="true" />
                                            )}
                                        </span>
                                    </Disclosure.Button>
                                </h3>
                                <Disclosure.Panel className="pt-6">
                                    <div className="space-y-4">
                                        {section.options.map((option, optionIdx) => (
                                            <div key={option.value} className="flex items-center">
                                                <input
                                                    id={`filter-${section.id}-${optionIdx}`}
                                                    name={`${section.id}[]`}
                                                    defaultValue={option.value}
                                                    type="checkbox"
                                                    defaultChecked={option.checked}
                                                    className="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500"
                                                />
                                                <label
                                                    htmlFor={`filter-${section.id}-${optionIdx}`}
                                                    className="ml-3 text-sm text-white"
                                                >
                                                    {option.label}
                                                </label>
                                            </div>
                                        ))}
                                    </div>
                                </Disclosure.Panel>
                            </>
                        )}
                    </Disclosure>

                ))}
            </div>
        </form>
    )
}